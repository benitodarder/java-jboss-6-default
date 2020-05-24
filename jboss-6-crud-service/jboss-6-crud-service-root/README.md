
Sample HSQLDB command: 

	java -cp /opt/hsqldb/1.8.1.3/lib/hsqldb.jar org.hsqldb.Server -silent false -database.0 file:/home/benitodarder/Development/databases/hsqldb/webappJBoss6.1/products/products.db -dbname.0 products

Sample JNDI entry:

   <local-tx-datasource>  
      <jndi-name>product</jndi-name>
      <connection-url>jdbc:hsqldb:hsql://localhost:9001/products</connection-url>
      <driver-class>org.hsqldb.jdbcDriver</driver-class>
      <user-name>sa</user-name>
      <password></password>
      <min-pool-size>5</min-pool-size>
      <max-pool-size>20</max-pool-size>
      <idle-timeout-minutes>0</idle-timeout-minutes>
      <prepared-statement-cache-size>32</prepared-statement-cache-size>
   </local-tx-datasource>
