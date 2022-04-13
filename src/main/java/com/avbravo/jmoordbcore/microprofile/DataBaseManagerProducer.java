package com.avbravo.jmoordbcore.microprofile;

/*-
 * #%L
 * microstream-integrations-cdi
 * %%
 * Copyright (C) 2019 - 2022 MicroStream Software
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.ejb.ConcurrencyManagement;
import jakarta.ejb.ConcurrencyManagementType;
import jakarta.inject.Singleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.eclipse.microprofile.config.Config;

//@ApplicationScoped
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class DataBaseManagerProducer implements Serializable{

    @Inject
    Logger LOG;

    @Inject
    private Config config;

    @Produces
    @ApplicationScoped
    public MongoClient mongoClient() {
        MongoClient mongoClient;
        try {
            final Map<String, String> properties = MicroprofileConfigFile.getProperties(this.config);
            LOG.info(
                    "Loading default MongoClient  loading from MicroProfile Config properties. The keys: "
                    + properties.keySet()
            );

            //final EmbeddedStorageConfigurationBuilder builder = EmbeddedStorageConfigurationBuilder.New();
            for (final Map.Entry<String, String> entry : properties.entrySet()) {
                System.out.println("key " + entry.getKey() + " value " + entry.getValue());
                //builder.set(entry.getKey(), entry.getValue());
            }
            //	return builder.createEmbeddedStorageFoundation().start();

            mongoClient = MongoClients.create(System.getProperty("mongodb.uri"));
  return mongoClient;
            //MongoClient mongoClient = new MongoClient( "host1" );
//            String uri = JmoordbContext.get("uri") == null ? "" : (String) JmoordbContext.get("uri");
//            if (uri == null || uri.isEmpty()) {
//                String username = JmoordbContext.get("username") == null ? "" : (String) JmoordbContext.get("username");
//                String password = JmoordbContext.get("password") == null ? "" : (String) JmoordbContext.get("password");
//                String database = JmoordbContext.get("database") == null ? "" : (String) JmoordbContext.get("database");
//                String host = JmoordbContext.get("host") == null ? "" : (String) JmoordbContext.get("host");
//                String port = JmoordbContext.get("port") == null ? "" : (String) JmoordbContext.get("port");
//                Boolean security = JmoordbContext.get("security") == null ? false : (Boolean) JmoordbContext.get("security");
//                if (security == null && username == null) {
//                    security = false;
//                }
//                if (security) {
//
//                    char[] charArray = password.toCharArray();
//                    MongoCredential credential = MongoCredential.createCredential(username, database, charArray);
//                    ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));
////             mongo = new MongoClient(serverAddress, new ArrayList<>());
//
//                    mongo = new MongoClient(serverAddress, new ArrayList<MongoCredential>() {
//                        {
//                            add(credential);
//                        }
//                    });
////           
//                } else {
//                    mongo = new MongoClient();
//                }
//            } else {
//                System.out.println("--->conectacndose a MongoDB Atlas");
//                //Para conexion por uri generalmente de MongoDB Atlas
//                mongo = new MongoClient(new MongoClientURI(uri));
//            }
        } catch (Exception e) {
            System.out.println("error() " + e.getLocalizedMessage());
            //       JmoordbUtil.errorMessage("conecction() "+e.getLocalizedMessage());
        }

        return null;
    }

//	public void dispose(@Disposes final StorageManager manager)
//	{
//		LOGGER.info("Closing the default StorageManager");
//		manager.close();
//		LOGGER.info("Closing the LazyReferenceManager");
//		final LazyReferenceManager referenceManager = LazyReferenceManager.get();
//		referenceManager.stop();
//	}
}
