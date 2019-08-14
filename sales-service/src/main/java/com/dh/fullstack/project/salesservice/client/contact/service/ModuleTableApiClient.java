package com.dh.fullstack.project.salesservice.client.contact.service;

import com.dh.chat.contact.service.input.TableApiCreateInput;
import com.dh.fullstack.project.salesservice.client.contact.model.TableAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Julio Daviu
 */
@FeignClient("${service.client.contact.name}")
interface ModuleTableApiClient {

    @RequestMapping(value = "/system/tableapi", method = RequestMethod.POST)
    TableAPI createTableApi(@RequestBody TableApiCreateInput input);
}
