#ifndef D_CircularBuffer_H
#define D_CircularBuffer_H

class CircularBuffer
{
public:
    explicit CircularBuffer(int capacity = CAPACITY);
    virtual ~CircularBuffer();

    void Put(int);
    int Get();
    bool IsEmpty();
    bool IsFull();
    int Capacity();
    int Next(int i);

private:
    int index;
    int outdex;
    int* buffer;
    int capacity;
    enum
    {
        CAPACITY = 5
    };
    bool empty;
    bool full;

    CircularBuffer(const CircularBuffer&);
    CircularBuffer& operator=(const CircularBuffer&);

};

#endif  // D_CircularBuffer_H	
