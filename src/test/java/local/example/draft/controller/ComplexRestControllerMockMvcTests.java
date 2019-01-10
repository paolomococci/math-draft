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
public class ComplexRestControllerMockMvcTests {
    
    private static final String PATH = "/rest-complex";
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
    .andExpect(jsonPath("$.real.value").isNumber());
    }
    
    @Test
    public void testRealRestControllerValue()
    throws Exception {
    mockMvc.perform(get(PATH))
    .andExpect(jsonPath("$.real.value").value(0.27586206896551724137931034482759));
    }
    
    @Test
    public void testImagRestControllerValueType()
    throws Exception {
    mockMvc.perform(get(PATH))
    .andExpect(jsonPath("$.imag.value").isNumber());
    }
    
    @Test
    public void testImagRestControllerValue()
    throws Exception {
    mockMvc.perform(get(PATH))
    .andExpect(jsonPath("$.imag.value").value(-0.31034482758620689655172413793103));
    }
    
    @Test
    public void testRhoRestControllerValueType()
    throws Exception {
    mockMvc.perform(get(PATH))
    .andExpect(jsonPath("$.rho.value").isNumber());
    }
    
    @Test
    public void testRhoRestControllerValue()
    throws Exception {
    mockMvc.perform(get(PATH))
    .andExpect(jsonPath("$.rho.value").value(0.41522739926));
    }
    
    @Test
    public void testThetaRestControllerValueType()
    throws Exception {
    mockMvc.perform(get(PATH))
    .andExpect(jsonPath("$.theta.value").isNumber());
    }
    
    @Test
    public void testThetaRestControllerValue()
    throws Exception {
    mockMvc.perform(get(PATH))
    .andExpect(jsonPath("$.theta.value").value(-0.844153986113171));
    }
}
