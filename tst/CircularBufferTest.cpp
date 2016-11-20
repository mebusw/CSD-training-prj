#include "CppUTest/TestHarness.h"
#include "CircularBuffer.h"

TEST_GROUP(CircularBuffer)
{ CircularBuffer* buffer;

void setup()
{
    buffer = new CircularBuffer();
}
void teardown()
{
    delete buffer;
}

void fillTheQueue(int seed, int howMany)
{
    for (int i = 0; i < howMany; i++)
    buffer->Put(seed + i);
}
void removeFromQueue(int howMany)
{
    for (int i = 0; i < howMany; i++)
    buffer->Get();
}
};

TEST(CircularBuffer, EmptyAfterCreation)
{
    CHECK(buffer->IsEmpty());

    LONGS_EQUAL(42, 42);
    CHECK(1);
    CHECK_TRUE(1);
    CHECK_FALSE(0);
    STRCMP_EQUAL("hey", "hey");
    //FAIL("Start here");
}
