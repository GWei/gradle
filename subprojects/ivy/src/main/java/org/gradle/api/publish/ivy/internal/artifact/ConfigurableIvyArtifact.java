/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.publish.ivy.internal.artifact;

import org.gradle.api.publish.ivy.IvyArtifact;

abstract class ConfigurableIvyArtifact implements IvyArtifact {
    private String name;
    private String type;
    private String extension;

    protected abstract String getBaseName();
    protected abstract String getBaseType();
    protected abstract String getBaseExtension();

    public String getName() {
        return name == null ? getBaseName() : name;
    }

    public void setName(String name) {
        this.name = notNull(name);
    }
    
    public String getType() {
        return type == null ? nullToEmpty(getBaseType()) : type;
    }

    public void setType(String type) {
        this.type = notNull(type);
    }
    
    public String getExtension() {
        return extension == null ? nullToEmpty(getBaseExtension()) : extension;
    }

    public void setExtension(String extension) {
        this.extension = notNull(extension);
    }

    private String nullToEmpty(String input) {
        return input == null ? "" : input;
    }

    private String notNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
