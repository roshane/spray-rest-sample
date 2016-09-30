package com.conf

import com.escalatesoft.subcut.inject.NewBindingModule
import com.repository.TodoRepository
import com.repository.impl.TodoRepositoryImpl
import com.service.TodoService
import com.service.impl.TodoServiceImpl

/**
 * Created by roshane on 9/29/16.
 */
object ApiServiceModule extends NewBindingModule(implicit module => {
  import module._

  bind[TodoService] toSingle new TodoServiceImpl
  bind[TodoRepository] toSingle new TodoRepositoryImpl

})
