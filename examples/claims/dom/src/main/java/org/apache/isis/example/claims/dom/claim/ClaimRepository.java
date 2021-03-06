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

package org.apache.isis.example.claims.dom.claim;

import java.util.List;

import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotContributed;
import org.apache.isis.applib.annotation.NotInServiceMenu;
import org.apache.isis.applib.value.Date;

@Named("Claims")
public interface ClaimRepository {

    public List<Claim> allClaims();

    public List<Claim> findClaims(@Named("Description") String description);

    public List<Claim> claimsFor(Claimant claimant);

    @NotInServiceMenu
    public List<Claim> claimsSince(Claimant claimant, Date since);

    public Claim newClaim(Claimant claimant);

    @Named("New Claim")
    public Claim newClaimWithDescription(Claimant claimant, String description);

    @NotContributed
    int countClaimsFor(Claimant claimant);

    @NotContributed
    Claim mostRecentClaim(Claimant claimant);
}
