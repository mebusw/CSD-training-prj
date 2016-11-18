#include "CircularBuffer.h"

CircularBuffer::CircularBuffer(int _capacity) :
    index(0), outdex(0), capacity(_capacity), empty(true), full(false)
{
    buffer = new int[this->capacity];
}

CircularBuffer::~CircularBuffer()
{
    delete[] buffer;
}

void CircularBuffer::Put(int i)
{
    empty = false;
    buffer[index] = i;
    index = Next(index);
    if (full) outdex = Next(outdex);
    else if (index == outdex) full = true;
}

int CircularBuffer::Get()
{
    int result = -1;
    full = false;

    if (!empty) {
        result = buffer[outdex];
        outdex = Next(outdex);
        if (outdex == index) empty = true;
    }
    return result;
}

int CircularBuffer::Capacity()
{
    return capacity;
}

int CircularBuffer::Next(int i)
{
    if (++i >= capacity) i = 0;
    return i;
}

bool CircularBuffer::IsEmpty()
{
	return true;
}