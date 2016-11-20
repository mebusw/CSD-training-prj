#include "CppUTest/TestHarness.h"
#include "MockPrinter.h"
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

TEST(CircularBuffer, Capacity)
{
    CircularBuffer b(2);
    LONGS_EQUAL(2, b.Capacity());
}

TEST(CircularBuffer, IsFull)
{
    fillTheQueue(0, buffer->Capacity());
    CHECK(buffer->IsFull());
}

TEST(CircularBuffer, EmptyToFullToEmpty)
{
    fillTheQueue(100, buffer->Capacity());

    CHECK(buffer->IsFull());

    removeFromQueue(buffer->Capacity());

    CHECK(buffer->IsEmpty());
}

TEST(CircularBuffer, WrapAround)
{
    fillTheQueue(100, buffer->Capacity());

    CHECK(buffer->IsFull());
    LONGS_EQUAL(100, buffer->Get());
    CHECK(!buffer->IsFull());
    buffer->Put(1000);
    CHECK(buffer->IsFull());

    removeFromQueue(buffer->Capacity() - 1);

    LONGS_EQUAL(1000, buffer->Get());
    CHECK(buffer->IsEmpty());
}

TEST(CircularBuffer, PutToFull)
{
    int capacity = buffer->Capacity();
    fillTheQueue(900, capacity);
    buffer->Put(9999);

    for (int i = 0; i < buffer->Capacity() - 1; i++)
        LONGS_EQUAL(i+900+1, buffer->Get());

    LONGS_EQUAL(9999, buffer->Get());
    CHECK(buffer->IsEmpty());
}

//Sometime people ask what tests the tests.
//Do you know the answer


TEST(CircularBuffer, GetFromEmpty)
{
    LONGS_EQUAL(-1, buffer->Get());
    CHECK(buffer->IsEmpty());
}

/*
 * the next tests demonstrate using a mock object for
 * capturing output
 *
 */

TEST(CircularBuffer, PrintEmpty)
{
    MockPrinter mock;
    Printer* p = &mock;

    buffer->Print(p);
    STRCMP_EQUAL("Circular buffer content:\n<>\n",
            mock.getOutput().c_str());
}

TEST(CircularBuffer, PrintAfterOnePut)
{
    MockPrinter mock;

    buffer->Put(1);
    buffer->Print(&mock);
    STRCMP_EQUAL("Circular buffer content:\n<1>\n",
            mock.getOutput().c_str());
}

TEST(CircularBuffer, PrintNotYetWrappedOrFull)
{
    MockPrinter mock;

    buffer->Put(1);
    buffer->Put(2);
    buffer->Put(3);
    buffer->Print(&mock);
    STRCMP_EQUAL("Circular buffer content:\n<1, 2, 3>\n",
            mock.getOutput().c_str());
}

TEST(CircularBuffer, PrintNotYetWrappedAndIsFull)
{
    MockPrinter mock;

    fillTheQueue(200, buffer->Capacity());

    buffer->Print(&mock);
    const char* expected = "Circular buffer content:\n"
        "<200, 201, 202, 203, 204>\n";

    STRCMP_EQUAL(expected, mock.getOutput().c_str());
}

TEST(CircularBuffer, PrintWrappedAndIsFullOldestToNewest)
{
    MockPrinter mock;

    fillTheQueue(200, buffer->Capacity());
    buffer->Get();
    buffer->Put(999);

    buffer->Print(&mock);
    const char* expected = "Circular buffer content:\n"
        "<201, 202, 203, 204, 999>\n";

    STRCMP_EQUAL(expected, mock.getOutput().c_str());
}

TEST(CircularBuffer, PrintWrappedAndFullOverwriteOldest)
{
    MockPrinter mock;

    fillTheQueue(200, buffer->Capacity());
    buffer->Put(9999);

    buffer->Print(&mock);
    const char* expected = "Circular buffer content:\n"
        "<201, 202, 203, 204, 9999>\n";

    STRCMP_EQUAL(expected, mock.getOutput().c_str());
}

TEST(CircularBuffer, PrintBoundary)
{
    MockPrinter mock;

    fillTheQueue(200, buffer->Capacity());
    removeFromQueue(buffer->Capacity() - 2);
    buffer->Put(888);
    fillTheQueue(300, buffer->Capacity() - 1);

    buffer->Print(&mock);
    const char* expected = "Circular buffer content:\n"
        "<888, 300, 301, 302, 303>\n";

    STRCMP_EQUAL(expected, mock.getOutput().c_str());
}

TEST(CircularBuffer, FillEmptyThenPrint)
{
    MockPrinter mock;

    fillTheQueue(200, buffer->Capacity());
    removeFromQueue(buffer->Capacity());
    buffer->Print(&mock);
    const char* expected = "Circular buffer content:\n"
        "<>\n";

    STRCMP_EQUAL(expected, mock.getOutput().c_str());
}
