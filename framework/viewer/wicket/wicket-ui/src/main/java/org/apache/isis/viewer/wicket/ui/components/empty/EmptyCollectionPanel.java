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

package org.apache.isis.viewer.wicket.ui.components.empty;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.Model;

import org.apache.isis.viewer.wicket.model.models.ActionModel;
import org.apache.isis.viewer.wicket.ui.panels.PanelAbstract;

public class EmptyCollectionPanel extends PanelAbstract<ActionModel> {

    private static final long serialVersionUID = 1L;

    public EmptyCollectionPanel(final String id, final ActionModel model) {
        super(id, model);
        buildGui(id);
    }

    private void buildGui(final String id) {
        final ActionModel model = getModel();
        addOrReplace(new Button("ok", Model.of("OK")) { // TODO: i18n

            private static final long serialVersionUID = 1L;

            @Override
            public void onSubmit() {
                model.getNoResultsHandler().onNoResults(this);
            }
        });
    }

}
