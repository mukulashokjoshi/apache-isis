/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.isis.core.progmodel.facets.object.ignore.jdo;


import java.lang.reflect.Method;

import org.apache.isis.core.metamodel.facetapi.FeatureType;
import org.apache.isis.core.metamodel.facets.FacetFactoryAbstract;

/**
 * Removes all methods inherited from <tt>javax.jdo.spi.PersistenceCapable</tt> (if JDO is on the classpath).
 */
public class RemoveJdoPrefixedMethodsFacetFactory extends FacetFactoryAbstract {

    public RemoveJdoPrefixedMethodsFacetFactory() {
        super(FeatureType.OBJECTS_ONLY);
    }
    
    @Override
    public void process(ProcessClassContext context) {
        Class<?> cls = context.getCls();
        Method[] methods = cls.getMethods();
        for(Method method: methods) {
            if(method.getName().startsWith("jdo")) {
                context.removeMethod(method);
            }
        }
    }

}
