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
package org.apache.isis.viewer.restfulobjects.viewer.resources.domainobjects;

import org.apache.isis.core.metamodel.adapter.ObjectAdapter;
import org.apache.isis.core.metamodel.spec.feature.ObjectAction;
import org.apache.isis.viewer.restfulobjects.applib.JsonRepresentation;

public class ObjectAndActionInvocation {

    private final ObjectAdapter objectAdapter;
    private final ObjectAction action;
    private final JsonRepresentation arguments;
    private final ObjectAdapter returnedAdapter;

    public ObjectAndActionInvocation(final ObjectAdapter objectAdapter, final ObjectAction action, final JsonRepresentation arguments, final ObjectAdapter returnedAdapter) {
        this.objectAdapter = objectAdapter;
        this.action = action;
        this.arguments = arguments;
        this.returnedAdapter = returnedAdapter;
    }

    public ObjectAdapter getObjectAdapter() {
        return objectAdapter;
    }

    public ObjectAction getAction() {
        return action;
    }

    public JsonRepresentation getArguments() {
        return arguments;
    }

    public ObjectAdapter getReturnedAdapter() {
        return returnedAdapter;
    }

}