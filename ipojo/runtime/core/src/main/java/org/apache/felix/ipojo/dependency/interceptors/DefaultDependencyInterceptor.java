/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.felix.ipojo.dependency.interceptors;

import org.apache.felix.ipojo.util.DependencyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A default implementation of the dependency interceptor.
 * It manages the dependency list guarded by the monitor lock.
 */
public class DefaultDependencyInterceptor implements DependencyInterceptor {

    /**
     * The set of managed dependencies.
     * Access must be guarded by the monitor lock.
     */
    protected final List<DependencyModel> dependencies = new ArrayList<DependencyModel>();


    /**
     * Closes the interception of the given dependency.
     * @param dependency the dependency stopping its use of the interceptor
     */
    public void close(DependencyModel dependency) {
        synchronized (this) {
            dependencies.remove(dependency);
        }
    }

    /**
     * Opens the interception of the given dependency.
     * @param dependency the dependency starting using the interceptor.
     */
    public void open(DependencyModel dependency) {
        synchronized (this) {
            dependencies.add(dependency);
        }
    }
}
