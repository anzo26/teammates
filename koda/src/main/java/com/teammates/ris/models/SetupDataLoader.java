package com.teammates.ris.models;

import com.teammates.ris.dao.PrivilegeRepository;
import com.teammates.ris.dao.RoleRepository;
import com.teammates.ris.dao.UporabnikRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

        boolean alreadySetup = false;

@Autowired
private UporabnikRepository uporabnikDao;

@Autowired
private RoleRepository roleDao;

@Autowired
private PrivilegeRepository privilegeDao;


@Override
@Transactional
public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
        return;
        Privilege readPrivilege
        = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
        = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        Collection<Privilege> adminPrivileges = Arrays.asList(
        readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleDao.findByName("ROLE_ADMIN");
        Uporabnik user = new Uporabnik();
        user.setIme("Test");
        user.setPriimek("Test");
        user.setUporabnisko_ime("Test");
        user.setGeslo("test");
        user.setEmail("test@test.com");
        user.setPriljubljeni_sporti("nogomet");

        user.setRoles(Arrays.asList(adminRole));
        uporabnikDao.save(user);

        alreadySetup = true;
        }

@Transactional
    Privilege createPrivilegeIfNotFound(String name) {

            Privilege privilege = privilegeDao.findByName(name);
            if (privilege == null) {
            privilege = new Privilege(name);
            privilegeDao.save(privilege);
            }
            return privilege;
            }

@Transactional
    Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleDao.findByName(name);
        if (role == null) {
        role = new Role(name);
        role.setPrivileges(privileges);
        roleDao.save(role);
        }
        return role;
        }
        }
