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

package org.apache.isis.core.progmodel.app;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.jmock.auto.Mock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.apache.isis.core.metamodel.progmodel.ProgrammingModel;
import org.apache.isis.core.metamodel.runtimecontext.RuntimeContext;
import org.apache.isis.core.testsupport.jmock.JUnitRuleMockery2;
import org.apache.isis.core.testsupport.jmock.JUnitRuleMockery2.Mode;

public class IsisMetaModelBaseTest_constructDefaults {

    @Rule
    public final JUnitRuleMockery2 context = JUnitRuleMockery2.createFor(Mode.INTERFACES_ONLY);

    @Mock
    private RuntimeContext mockContext;

    @Mock
    private ProgrammingModel mockProgrammingModel;
    
    private IsisMetaModel metaModel;

    @Before
    public void setUp() {
        metaModel = new IsisMetaModel(mockContext, mockProgrammingModel);
    }

    @Test
    public void shouldDefaultConfiguration() {
        assertThat(metaModel.getConfiguration(), is(notNullValue()));
    }

    @Test
    public void shouldDefaultClassSubstitutor() {
        assertThat(metaModel.getClassSubstitutor(), is(notNullValue()));
    }

    @Test
    public void shouldDefaultProgrammingModelFacets() {
        assertThat(metaModel.getProgrammingModelFacets(), is(notNullValue()));
    }

    @Test
    public void shouldDefaultCollectionTypeRegistry() {
        assertThat(metaModel.getCollectionTypeRegistry(), is(notNullValue()));
    }

    @Test
    public void shouldDefaultFacetDecorators() {
        assertThat(metaModel.getFacetDecorators(), is(notNullValue()));
    }

    @Test
    public void shouldHaveNoFacetDecorators() {
        assertThat(metaModel.getFacetDecorators().size(), is(0));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotBeAbleToShutdown() {
        metaModel.shutdown();
    }

}
