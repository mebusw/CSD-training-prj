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
}

TEST(CircularBuffer, NotEmpty)
{
    buffer->Put(10046);
    CHECK(!buffer->IsEmpty());
}

TEST(CircularBuffer, NotEmptyThenEmpty)
{
    buffer->Put(4567);
    CHECK(!buffer->IsEmpty());
    buffer->Get();
    CHECK(buffer->IsEmpty());
}

TEST(CircularBuffer, GetPutOneValue)
{
    buffer->Put(4567);
    LONGS_EQUAL(4567, buffer->Get());
}

TEST(CircularBuffer, GetPutAFew)
{
    buffer->Put(1);
    buffer->Put(2);
    buffer->Put(3);
    LONGS_EQUAL(1, buffer->Get());
    LONGS_EQUAL(2, buffer->Get());
    LONGS_EQUAL(3, buffer->Get());
}
