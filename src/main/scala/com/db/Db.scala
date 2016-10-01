package com.db

import com.mongodb.casbah.MongoCollection

/**
 * Created by roshane on 10/1/16.
 */
trait Db {

  def todoCollection:MongoCollection

}
