#include "CppUTest/TestHarness.h"
#include "One.h"

TEST_GROUP(One)
{ 
    One* one;

    void setup()
    {
        one = new One();
    }
    void teardown()
    {
        delete one;
    }
};

TEST(One, StartHere)
{
    CHECK_FALSE(one->calc());

    LONGS_EQUAL(42, 6 * 7);
    CHECK(1);
    CHECK_TRUE(1);
    CHECK_FALSE(0);
    STRCMP_EQUAL("hey", "hey");
    //FAIL("Start here");}
}