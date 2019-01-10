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

import local.example.draft.number.Imag;
import local.example.draft.number.Real;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author paolo mococci
 */

@RestController
public class ImagRestController {
    
    @RequestMapping(value = "/rest-imaginary-coefficient", 
            method = RequestMethod.GET)
    public Imag defaultResponse() {
        Imag i = new Imag();
        Real r = new Real();
        i.setValue(7.0D);
        r.setValue(5.0D);
        i.quotient(i, r);
        i.setScale(14);
        return i;
    }    
}
