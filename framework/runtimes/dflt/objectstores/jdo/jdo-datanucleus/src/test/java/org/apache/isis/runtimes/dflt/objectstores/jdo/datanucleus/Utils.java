package org.apache.isis.runtimes.dflt.objectstores.jdo.datanucleus;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.isis.core.commons.config.IsisConfiguration;
import org.apache.isis.core.commons.config.IsisConfigurationDefault;
import org.apache.isis.runtimes.dflt.objectstores.jdo.datanucleus.DataNucleusObjectStore;
import org.apache.isis.runtimes.dflt.objectstores.jdo.datanucleus.DataNucleusPersistenceMechanismInstaller;
import org.apache.isis.runtimes.dflt.objectstores.jdo.datanucleus.metamodel.specloader.progmodelfacets.DataNucleusProgrammingModelFacets;
import org.apache.isis.runtimes.dflt.objectstores.jdo.metamodel.specloader.validator.JdoMetaModelValidator;
import org.apache.isis.runtimes.dflt.runtime.system.context.IsisContext;
import org.apache.isis.runtimes.dflt.testsupport.IsisSystemWithFixtures;

public class Utils {

    private Utils(){}

    public static IsisSystemWithFixtures.Builder systemBuilder() {
        return IsisSystemWithFixtures.builder()
        .with(configurationForDataNucleusDb())
        .with(new DataNucleusProgrammingModelFacets())
        .with(new JdoMetaModelValidator())
        .with(new DataNucleusPersistenceMechanismInstaller());
    }

    public static IsisSystemWithFixtures.Listener listenerToDeleteFrom(final String... tables) {
        return new IsisSystemWithFixtures.ListenerAdapter(){

            @Override
            public void postSetupSystem(boolean firstTime) throws Exception {
                Connection connection = getConnection();
                try {
                    final Statement statement = connection.createStatement();
                    for(String table: tables) {
                        statement.executeUpdate("DELETE FROM " + table);
                    }
                } catch(Exception ex) {
                    connection.rollback();
                    throw ex;
                } finally {
                    connection.commit();
                }
            }

            private Connection getConnection() {
                final DataNucleusObjectStore objectStore = (DataNucleusObjectStore) IsisContext.getPersistenceSession().getObjectStore();
                return objectStore.getJavaSqlConnection();
            }
        };
    }

    public static IsisConfiguration configurationForDataNucleusDb() {
        final IsisConfigurationDefault configuration = new IsisConfigurationDefault();
        Properties props = new Properties();
        
        props.put("isis.persistor.datanucleus.impl.javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        
        //props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionDriverName", "org.hsqldb.jdbcDriver");
        //props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionURL", "jdbc:hsqldb:mem:test");
        ////props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionURL", "jdbc:hsqldb:file:hsql-db/test;hsqldb.write_delay=false;shutdown=true");
        //props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionUserName", "sa");
        //props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionPassword", "");

        props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionDriverName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionURL", "jdbc:sqlserver://127.0.0.1:1433;instance=SQLEXPRESS;databaseName=jdo;");
        props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionUserName", "jdo");
        props.put("isis.persistor.datanucleus.impl.javax.jdo.option.ConnectionPassword", "jdopass");

        props.put("isis.persistor.datanucleus.impl.datanucleus.autoCreateSchema", "true");
        props.put("isis.persistor.datanucleus.impl.datanucleus.validateTables", "true");
        props.put("isis.persistor.datanucleus.impl.datanucleus.validateConstraints", "true");
        configuration.add(props);
        return configuration;
    }

}
