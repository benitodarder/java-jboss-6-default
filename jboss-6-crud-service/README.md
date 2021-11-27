# jboss-6-crud-service

Sample HSQLDB command: 

* java -cp /opt/hsqldb/1.8.1.3/lib/hsqldb.jar org.hsqldb.Server -silent false -database.0 file:/home/benitodarder/Development/databases/hsqldb/webappJBoss6.1/products/products.db -dbname.0 products

* java -cp /c/programs/hsqldb/1.8.1.3/lib/hsqldb.jar org.hsqldb.Server -silent false -database.0 file:/c/Users/benitodarder/Development/databases/jboss6CRUD/products.db -dbname.0 products

Sample JNDI entry:

   &lt;local-tx-datasource&gt;  
      &lt;jndi-name&gt;product&lt;/jndi-name&gt;<br/>
      &lt;connection-url&gt;jdbc:hsqldb:hsql://localhost:9001/products&lt;/connection-url&gt;<br/>
      &lt;driver-class&gt;org.hsqldb.jdbcDriver&lt;/driver-class&gt;<br/>
      &lt;user-name&gt;sa&lt;/user-name&gt;<br/>
      &lt;password&gt;&lt;/password&gt;<br/>
      &lt;min-pool-size&gt;5&lt;/min-pool-size&gt;<br/>
      &lt;max-pool-size&gt;20&lt;/max-pool-size&gt;<br/>
      &lt;idle-timeout-minutes&gt;0&lt;/idle-timeout-minutes&gt;<br/>
      &lt;prepared-statement-cache-size&gt;32&lt;/prepared-statement-cache-size&gt;<br/>
   &lt;/local-tx-datasource&gt;<br/>
