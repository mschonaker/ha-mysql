# HA MySQL Example

A Dockerized example of a cluster of MySQL Galera Cluster multi-master 
replication nodes with a couple of Wildfly replicated servers along with a
Nginx balancing the load of both Wildfly nodes.

NOT FOR [PRODUCTION](https://docs.docker.com/compose/production/)


This example requires Docker, Docker Compose and Maven already installed.

## Building

```
./build.sh
```

## Running

```
docker-compose up --force-recreate --build --remove-orphans
```
