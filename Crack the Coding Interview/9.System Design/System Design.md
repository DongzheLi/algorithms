# System Design and Scalability

## Design System : Step-by-Step

1. Scope the problem

    Ask questions until you have a list of major features.

2. State your reasonable Assumptions

3. Draw the Major Components

    Walk through your system from end-to-end to provide a flow.

4. Identify the key Issues(Bottlenecks)
5. Redesign for the Key Issues

## Algorithms that Scale: Step-by-Step

## Key Concepts

1. Horizontal vs. Vertical Scaling

    + vertical scaling: add additional memory to a server
    + horizontal scaling: increase number of servers.

2. Load Balancer

    + Some frontend parts of a scalable website will be thrown behind a load balancer. This allows the system to distribute the load evenly so that one server doesn't crash and take down the whole system.

3. Database Denormalization and NoSQL
    
    + When SQL database gets too big, join operations gets slow. 
    + Denormalization means adding redundant information into a database to speed up reads. project x task is too slow, you need to find project name, then just store the project name within the task table.
    + Switch to a NoSQL database, it's designed to scale better.

4. Partition database

    You need to figure out post-partition, which database has your required information.

    + Vertical partition: partition by feature.
    + HashMap partition: Assign id to data, then hash table
    + Directory-Based partition

5. Caching

    An in-memory cache can deliver very rapid results. It is a simple key-value pairing and typically sits between application layer and your data store.

6. Asynchronous Processing & Queues

    Slow operations should ideally be done asynchronously.

7. Networking Metrics

    + Bandwidth: Maximum amount of data can be transferred in a unit of time.
    + Throughput: Actuall amount of data that is transferred.
    + Latency: How long it takes data to go from one end to the other. 

8. MapReduce

    + Map takes in some data and emits a <key, value> pair.
    + Reduce takes a key and a set of associated values and "reduces" them in some way, emitting a new key and value