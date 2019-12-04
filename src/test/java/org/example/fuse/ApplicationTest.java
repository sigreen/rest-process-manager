/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.example.fuse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    // @Ignore
    public void newProcessManagerTest() {
        // Request External Eligibility
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization",
                "Bearer 4EiFw6sc9rvo33sfj9r0eSrWJCVl4RHXrB5RfqWOH0lZi-OAJwPtcmxBAQyl1qa8m_tvst8WDX3gMg5rlIQugc1hxK2FwajP1sBIj2uXdvLYJGC4KoObKmhJHqE37Tw_lJW9iQtUHLJG5j-LuCVzuOrnSZoWlI2OMdFSOIRV2Y3CPaaBHw4IDGM6eL99CH0jDGtMY1aAapKoYCsX7QYSbA6JZQw");
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString("/camel-rest-3scale/consumer-searchapi-web/subscribersearch").queryParam("first", "eddy")
                .queryParam("last", "reagan");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> usersResponse = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                String.class);
        assertThat(usersResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
