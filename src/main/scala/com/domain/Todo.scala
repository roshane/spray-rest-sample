package com.domain

import org.bson.types.ObjectId
import salat.annotations.raw.Key

/**
 * Created by roshane on 9/29/16.
 */

case class Todo(@Key("_id") id: String = new ObjectId().toString,
                label: String,
                description: String,
                completed: Boolean)
