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

package org.apache.felix.ipojo.extender.internal;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleReference;

import java.util.concurrent.Callable;

/**
 * A callable object implementing Bundle Reference.
 * It makes the Bundle object accessible by the processing job.
 * This class is intended to be extended.
 */
public abstract class ReferenceableCallable<T> implements Callable<T>, BundleReference {
    /**
     * The bundle object.
     */
    private final Bundle m_bundle;

    /**
     * Creates the ReferenceableCallable instance.
     *
     * @param bundle the associated bundle
     */
    protected ReferenceableCallable(Bundle bundle) {
        m_bundle = bundle;
    }

    /**
     * Gets the bundle object.
     *
     * @return the bundle
     */
    public Bundle getBundle() {
        return m_bundle;
    }

}
