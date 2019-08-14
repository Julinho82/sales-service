package com.dh.fullstack.project.salesservice.client.contact.service;

import com.dh.chat.contact.service.input.TableApiCreateInput;
import com.dh.fullstack.project.salesservice.client.contact.model.TableAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Julio Daviu
 */
@Service
public class SystemTableApiService {

    @Autowired
    private ModuleTableApiClient client;

    public TableAPI createTableApi(TableApiCreateInput input){
        return client.createTableApi(input);
    }
}
