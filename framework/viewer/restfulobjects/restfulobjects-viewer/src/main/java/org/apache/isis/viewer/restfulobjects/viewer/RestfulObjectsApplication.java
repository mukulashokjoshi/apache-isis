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
package org.apache.isis.viewer.restfulobjects.viewer;

import org.apache.isis.viewer.restfulobjects.viewer.resources.domainobjects.DomainObjectResourceServerside;
import org.apache.isis.viewer.restfulobjects.viewer.resources.domainobjects.DomainServiceResourceServerside;
import org.apache.isis.viewer.restfulobjects.viewer.resources.domaintypes.DomainTypeResourceServerside;
import org.apache.isis.viewer.restfulobjects.viewer.resources.home.HomePageResourceServerside;
import org.apache.isis.viewer.restfulobjects.viewer.resources.user.UserResourceServerside;
import org.apache.isis.viewer.restfulobjects.viewer.resources.version.VersionResourceServerside;

public class RestfulObjectsApplication extends AbstractJaxRsApplication {

    public static final String SPEC_VERSION = "0.52";

    public RestfulObjectsApplication() {
        addClass(HomePageResourceServerside.class);
        addClass(DomainTypeResourceServerside.class);
        addClass(UserResourceServerside.class);
        addClass(DomainObjectResourceServerside.class);
        addClass(DomainServiceResourceServerside.class);
        addClass(VersionResourceServerside.class);

        addSingleton(new RestfulObjectsApplicationExceptionMapper());
        addSingleton(new RuntimeExceptionMapper());

        // TODO: doesn't get injected
        // addSingleton(new TypedReprBuilderFactoryRegistry());

        // TODO: idea being to remove the init()
        // addSingleton(new PreProcessInterceptorForIsisSession());
    }

}
