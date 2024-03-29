/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.spinnaker;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Greg Turnquist
 */
@RestController
public class ApiController {

	@RequestMapping(method = RequestMethod.GET, value = ModuleController.BASE_PATH, produces = MediaTypes.HAL_JSON_VALUE)
	public ResponseEntity<?> root() {

		ResourceSupport root = new ResourceSupport();

		root.add(linkTo(methodOn(ApiController.class).root()).withSelfRel());
		root.add(linkTo(methodOn(ModuleController.class).statuses()).withRel("modules"));

		return ResponseEntity.ok(root);
	}

}
