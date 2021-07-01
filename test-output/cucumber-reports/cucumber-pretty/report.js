$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/API-Test.feature");
formatter.feature({
  "line": 1,
  "name": "API test",
  "description": "",
  "id": "api-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 8543495700,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Should see LIST USERS of all existing users",
  "description": "",
  "id": "api-test;should-see-list-users-of-all-existing-users",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@sc1"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "I get the default list of users for on 1st page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I get the list of all users",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I should see total users count equals to number of user ids",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_get_the_default_list_of_users_for_on_1st_page()"
});
formatter.result({
  "duration": 2149525900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_get_the_list_of_all_users()"
});
formatter.result({
  "duration": 7557485300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_should_see_total_users_count_equals_to_number_of_user_ids()"
});
formatter.result({
  "duration": 1145187700,
  "status": "passed"
});
formatter.after({
  "duration": 1098347900,
  "status": "passed"
});
formatter.before({
  "duration": 6431848800,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Should see SINGLE USER data",
  "description": "",
  "id": "api-test;should-see-single-user-data",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@sc2"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I make a search for user 3",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I should see following user data",
  "rows": [
    {
      "cells": [
        "Fields",
        "Values"
      ],
      "line": 12
    },
    {
      "cells": [
        "first_name",
        "George"
      ],
      "line": 13
    },
    {
      "cells": [
        "email",
        "george.bluth@reqres.in"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_make_a_search_for_user_3()"
});
formatter.result({
  "duration": 561942300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_should_see_following_user_data_and(DataTable)"
});
formatter.result({
  "duration": 490960000,
  "status": "passed"
});
formatter.after({
  "duration": 751536700,
  "status": "passed"
});
formatter.before({
  "duration": 4752299100,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Should see SINGLE USER NOT FOUND error code",
  "description": "",
  "id": "api-test;should-see-single-user-not-found-error-code",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@sc3"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "I make a search for user 55",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I receive error code \u003cstatus\u003e in response",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_make_a_search_for_user_55()"
});
formatter.result({
  "duration": 1453923200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cstatus\u003e",
      "offset": 21
    }
  ],
  "location": "StepDefinition.i_receive_error_code_in_response(String)"
});
formatter.result({
  "duration": 499465800,
  "status": "passed"
});
formatter.after({
  "duration": 786338700,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 22,
  "name": "CREATE a user",
  "description": "",
  "id": "api-test;create-a-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 21,
      "name": "@sc4"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "I create user with following \u003cName\u003e \u003cJob\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "response should contain folowing data",
  "rows": [
    {
      "cells": [
        "name",
        "job",
        "id",
        "createdAt"
      ],
      "line": 25
    }
  ],
  "keyword": "Then "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "api-test;create-a-user;",
  "rows": [
    {
      "cells": [
        "Name",
        "Job"
      ],
      "line": 28,
      "id": "api-test;create-a-user;;1"
    },
    {
      "cells": [
        "Peter",
        "Manager"
      ],
      "line": 29,
      "id": "api-test;create-a-user;;2"
    },
    {
      "cells": [
        "Liza",
        "Sales"
      ],
      "line": 30,
      "id": "api-test;create-a-user;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3559849100,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "CREATE a user",
  "description": "",
  "id": "api-test;create-a-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 21,
      "name": "@sc4"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "I create user with following Peter Manager",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "response should contain folowing data",
  "rows": [
    {
      "cells": [
        "name",
        "job",
        "id",
        "createdAt"
      ],
      "line": 25
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Peter",
      "offset": 29
    },
    {
      "val": "Manager",
      "offset": 35
    }
  ],
  "location": "StepDefinition.i_create_user_with_following(String,String)"
});
formatter.result({
  "duration": 1117790400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.response_should_contain_folowing_data(DataTable)"
});
formatter.result({
  "duration": 45200,
  "status": "passed"
});
formatter.after({
  "duration": 748973400,
  "status": "passed"
});
formatter.before({
  "duration": 7036088500,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "CREATE a user",
  "description": "",
  "id": "api-test;create-a-user;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 21,
      "name": "@sc4"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "I create user with following Liza Sales",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "response should contain folowing data",
  "rows": [
    {
      "cells": [
        "name",
        "job",
        "id",
        "createdAt"
      ],
      "line": 25
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Liza",
      "offset": 29
    },
    {
      "val": "Sales",
      "offset": 34
    }
  ],
  "location": "StepDefinition.i_create_user_with_following(String,String)"
});
formatter.result({
  "duration": 939308900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.response_should_contain_folowing_data(DataTable)"
});
formatter.result({
  "duration": 32800,
  "status": "passed"
});
formatter.after({
  "duration": 1174051800,
  "status": "passed"
});
formatter.before({
  "duration": 5429695200,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "LOGIN - SUCCESSFUL by a user",
  "description": "",
  "id": "api-test;login---successful-by-a-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 31,
      "name": "@sc5"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "I login succesfully with following data",
  "rows": [
    {
      "cells": [
        "Email",
        "Password"
      ],
      "line": 34
    },
    {
      "cells": [
        "eve.holt@reqres.in",
        "cityslicka"
      ],
      "line": 35
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.i_login_succesfully_with_following_data(DataTable)"
});
formatter.result({
  "duration": 1070936000,
  "status": "passed"
});
formatter.after({
  "duration": 781874000,
  "status": "passed"
});
formatter.before({
  "duration": 4322676000,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "LOGIN - UNSUCCESSFUL by a user",
  "description": "",
  "id": "api-test;login---unsuccessful-by-a-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 36,
      "name": "@sc6"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "I login unsuccesfully with following data",
  "rows": [
    {
      "cells": [
        "Email",
        "Password"
      ],
      "line": 39
    },
    {
      "cells": [
        "peter@klaven",
        "343sadssad"
      ],
      "line": 40
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.i_login_unsuccesfully_with_following_data(DataTable)"
});
formatter.result({
  "duration": 969709700,
  "status": "passed"
});
formatter.after({
  "duration": 770156500,
  "status": "passed"
});
formatter.before({
  "duration": 3808661300,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Should see list of users with DELAYED RESPONSE",
  "description": "",
  "id": "api-test;should-see-list-of-users-with-delayed-response",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 41,
      "name": "@sc7"
    }
  ]
});
formatter.step({
  "line": 43,
  "name": "I wait for user list to load",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "I should see that every user has a unique id",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_wait_for_user_list_to_load()"
});
formatter.result({
  "duration": 4066544400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_should_see_that_every_user_has_a_unique_id()"
});
formatter.result({
  "duration": 494323300,
  "status": "passed"
});
formatter.after({
  "duration": 878947100,
  "status": "passed"
});
formatter.uri("src/test/java/SampleTest.feature");
formatter.feature({
  "line": 1,
  "name": "BrightTalk  Sample Test",
  "description": "",
  "id": "brighttalk--sample-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3653576600,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Sample",
  "description": "",
  "id": "brighttalk--sample-test;sample",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am on the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.iAmOnTheHomePage()"
});
formatter.result({
  "duration": 12517092600,
  "status": "passed"
});
formatter.after({
  "duration": 1132699800,
  "status": "passed"
});
});