/**
 * 
 * Copyright 2018 paolo mococci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package local.example.draft.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author paolo mococci
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealRestControllerMockMvcTests {
    
    private static final String PATH = "/rest-real";
    private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext webAppCtx;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppCtx).build();
    }
    
    @Test
    public void testRealRestControllerStatusIsOk() 
            throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testRealRestControllerContentType() 
            throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"));
    }
    
    @Test
    public void testRealRestControllerValueType() 
            throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(jsonPath("$.value").isNumber());
    }
    
    @Test
    public void testRealRestControllerValue() 
            throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(jsonPath("$.value").value(1.34222591362126));
    }
}

