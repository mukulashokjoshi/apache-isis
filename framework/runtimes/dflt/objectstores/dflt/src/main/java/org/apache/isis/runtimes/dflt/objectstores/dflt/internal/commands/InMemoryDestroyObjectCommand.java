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

package org.apache.isis.runtimes.dflt.objectstores.dflt.internal.commands;

import org.apache.log4j.Logger;

import org.apache.isis.core.metamodel.adapter.ObjectAdapter;
import org.apache.isis.runtimes.dflt.objectstores.dflt.internal.ObjectStorePersistedObjects;
import org.apache.isis.runtimes.dflt.runtime.persistence.objectstore.transaction.DestroyObjectCommand;
import org.apache.isis.runtimes.dflt.runtime.persistence.objectstore.transaction.PersistenceCommandContext;
import org.apache.isis.runtimes.dflt.runtime.transaction.ObjectPersistenceException;

public final class InMemoryDestroyObjectCommand extends AbstractInMemoryPersistenceCommand implements DestroyObjectCommand {
    private final static Logger LOG = Logger.getLogger(InMemoryDestroyObjectCommand.class);

    public InMemoryDestroyObjectCommand(final ObjectAdapter adapter, final ObjectStorePersistedObjects persistedObjects) {
        super(adapter, persistedObjects);
    }

    @Override
    public void execute(final PersistenceCommandContext context) throws ObjectPersistenceException {
        if (LOG.isInfoEnabled()) {
            LOG.info("  delete object '" + onAdapter() + "'");
        }
        destroy(onAdapter());
    }

    @Override
    public String toString() {
        return "DestroyObjectCommand [object=" + onAdapter() + "]";
    }
}