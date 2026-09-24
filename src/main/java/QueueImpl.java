import org.apache.log4j.Logger;

public class QueueImpl<E> implements Queue<E>{
    final static Logger logger = Logger.getLogger(QueueImpl.class);

    final private E[] data;
    private int p;

    public QueueImpl(int len) {
        // TO-DO
        this.data = (E[])new Object[len];
        logger.info("nova cua de " + len+" elements");

    }

    public void push(E e) throws FullQueueException {
        // TO-DO
        logger.info("pre: 'push' nou element "+ e);
        if (isFull()) {
            logger.error("Cua plena");
            throw new FullQueueException();
        }

        this.data[this.p++]=e;
        logger.info("post: nou element "+ e);

    }


    public E pop() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        logger.info("pre: 'pop' nou element ");
        int i;
        E e = this.data[0];
        for (i=1; i<this.p; i++)
        {
            this.data[i-1] = this.data[i];
        }

        this.data[p] = null;
        this.p--;

        return e;
    }

    private boolean isFull() {
        return this.p == this.data.length;
    }

    private boolean isEmpty() {
        return this.p == 0;
    }

    public int size() {
        return this.p;
    }
}
