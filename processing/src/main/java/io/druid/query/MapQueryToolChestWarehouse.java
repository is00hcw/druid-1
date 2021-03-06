/*
 * Druid - a distributed column store.
 * Copyright 2012 - 2015 Metamarkets Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.druid.query;

import com.google.inject.Inject;

import java.util.Map;

/**
 */
public class MapQueryToolChestWarehouse implements QueryToolChestWarehouse
{
  private final Map<Class<? extends Query>, QueryToolChest> toolchests;

  @Inject
  public MapQueryToolChestWarehouse(
      Map<Class<? extends Query>, QueryToolChest> toolchests
  )
  {
    this.toolchests = toolchests;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T, QueryType extends Query<T>> QueryToolChest<T, QueryType> getToolChest(QueryType query)
  {
    return toolchests.get(query.getClass());
  }
}
