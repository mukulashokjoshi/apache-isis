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
package org.apache.isis.viewer.restfulobjects.applib.homepage;

import org.codehaus.jackson.JsonNode;

import org.apache.isis.viewer.restfulobjects.applib.links.LinkRepresentation;
import org.apache.isis.viewer.restfulobjects.domainobjects.DomainRepresentation;

public class HomePageRepresentation extends DomainRepresentation {

    public HomePageRepresentation(final JsonNode jsonNode) {
        super(jsonNode);
    }

    public LinkRepresentation getUser() {
        return getLinkWithRel("user");
    }

    public LinkRepresentation getServices() {
        return getLinkWithRel("services");
    }

    public LinkRepresentation getVersion() {
        return getLinkWithRel("version");
    }

}
