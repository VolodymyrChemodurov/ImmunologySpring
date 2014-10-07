package com.immunology.logic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.immunology.logic.dao.impl.UserDaoImplTest;
import com.immunology.logic.service.impl.UserDetailsServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({UserDaoImplTest.class, UserDetailsServiceImplTest.class})
public class ImmunologyTestSuite {

}
