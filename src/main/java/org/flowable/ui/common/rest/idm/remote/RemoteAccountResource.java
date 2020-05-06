package org.flowable.ui.common.rest.idm.remote;

import org.flowable.ui.common.model.UserRepresentation;
import org.flowable.ui.common.security.DefaultPrivileges;
import org.flowable.ui.common.service.exception.NotFoundException;
import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: flowable-learn
 * @description:
 * @author: LiuYunKai
 * @create: 2020-05-06 10:41
 **/
@RestController
@RequestMapping("/app")
public class RemoteAccountResource {

    @Autowired
    private RemoteIdmService remoteIdmService;

    /**
     * GET /rest/account -> get the current user.
     */
    @RequestMapping(value = "/rest/account", method = RequestMethod.GET, produces = "application/json")
    public UserRepresentation getAccount() {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName("admin");
        userRepresentation.setLastName("admin");
        userRepresentation.setFullName("admin");
        userRepresentation.setId("admin");
        List<String> pris = new ArrayList<>();
        pris.add(DefaultPrivileges.ACCESS_MODELER);
        pris.add(DefaultPrivileges.ACCESS_IDM);
        pris.add(DefaultPrivileges.ACCESS_ADMIN);
        pris.add(DefaultPrivileges.ACCESS_TASK);
        pris.add(DefaultPrivileges.ACCESS_REST_API);
        userRepresentation.setPrivileges(pris);

        if (userRepresentation != null) {
            return userRepresentation;
        } else {
            throw new NotFoundException();
        }
    }

}
