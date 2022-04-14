# jmoordbcore
jmoordbcore

busqueda
//             Consumer<Document> printConsumer = document -> 
//                     tlocal = (T) documentToJava.fromDocument(entityClass, document, embeddedModelList, referencedModelList, microservicesModelList);
//                    
//            
//db.getCollection(collection).find(new Document(key, value)).forEach(printConsumer);


 public T search(String key, String value) {
        try {

                MongoDatabase db = mongoClient().getDatabase(database);

            if (db == null) {
                return null;
            } else {
            }
//            FindIterable<Document> iterable = db.getCollection(collection).find(new Document(key, value));
//            ////Test.msg("+++ paso iterable");
//            haveElements = false;
//            iterable.forEach(new Block<Document>() {
//                @Override
//                public void apply(final Document document) {
//                    try {
//                        haveElements = true;
//                        tlocal = (T) documentToJava.fromDocument(entityClass, document, embeddedModelList, referencedModelList, microservicesModelList);
//                    } catch (Exception e) {          
//          excepcionManager(JmoordbUtil.nameOfClass() , JmoordbUtil.nameOfMethod(), e.getLocalizedMessage(), e);
//        }
//
//                }
//            });
 Consumer<Document> printConsumer = document -> 
                     tlocal = (T) documentToJava.fromDocument(entityClass, document, embeddedModelList, referencedModelList, microservicesModelList);
                    
            
db.getCollection(collection).find(new Document(key, value)).forEach(printConsumer);
            if (haveElements) {
                return tlocal;
            }
            return null;

        } catch (Exception e) {          
          excepcionManager(JmoordbUtil.nameOfClass() , JmoordbUtil.nameOfMethod(), e.getLocalizedMessage(), e);
        }

        return null;

    }// </editor-fold>




-----------------------------------------------------
Para Listas
-----------------------------------------------------
 private List< T> iterableList(FindIterable<Document> iterable) {
        List< T> l = new ArrayList<>();
        try {
            //Test.msg("-->IterableList::");
            
             Consumer<Document> printConsumer = document -> 
                     l.add( (T) documentToJava.fromDocument(entityClass, document, embeddedModelList, referencedModelList, microservicesModelList));
                    
            
iterable.forEach(printConsumer);

//            iterable.forEach(new Block<Document>() {
//                @Override
//                public void apply(final Document document) {
//                    try {
//                        //Test.msg("..........................................................................");
//                        //Test.msg("Prueba: iterable: "+document.toJson());
//                        t1 = (T) documentToJava.fromDocument(entityClass, document, embeddedModelList, referencedModelList, microservicesModelList);
//                        l.add(t1);
//                    } catch (Exception e) {          
//          excepcionManager(JmoordbUtil.nameOfClass() , JmoordbUtil.nameOfMethod(), e.getLocalizedMessage(), e);
//        }
//
//                }
//            });

       } catch (Exception e) {          
          excepcionManager(JmoordbUtil.nameOfClass() , JmoordbUtil.nameOfMethod(), e.getLocalizedMessage(), e);
        }
        return l;
    }// </editor-fold>

-----------------------------------------------------
## simple
-----------------------------------------------------
private T iterableSimple(FindIterable<Document> iterable) {
        try {
            //      ////Test.msg("$$$$$$$iterable simple");
            haveElements = false;
            
              
             Consumer<Document> printConsumer = document -> 
             tlocal = (T) documentToJava.fromDocument(entityClass, document, embeddedModelList, referencedModelList, microservicesModelList);
                    
            
iterable.forEach(printConsumer);
            
//             Consumer<Document> printConsumer = document -> 
//                     tlocal = (T) documentToJava.fromDocument(entityClass, document, embeddedModelList, referencedModelList, microservicesModelList);
//                    
//            
//db.getCollection(collection).find(new Document(key, value)).forEach(printConsumer);
//
//            iterable.forEach(new Block<Document>() {
//                @Override
//                public void apply(final Document document) {
//                    try {
//                        haveElements = true;
//                        t1 = (T) documentToJava.fromDocument(entityClass, document, embeddedModelList, referencedModelList, microservicesModelList);
//                    } catch (Exception e) {          
//          excepcionManager(JmoordbUtil.nameOfClass() , JmoordbUtil.nameOfMethod(), e.getLocalizedMessage(), e);
//        }
//
//                }
//            });

        } catch (Exception e) {          
          excepcionManager(JmoordbUtil.nameOfClass() , JmoordbUtil.nameOfMethod(), e.getLocalizedMessage(), e);
        }
        if (haveElements) {
            return (T) t1;
        }
        return null;

    }// </editor-fold>
