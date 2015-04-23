/*
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
package com.facebook.presto.sql.tree;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class DropTable
        extends Statement
{
    private final QualifiedName tableName;
    private final boolean existsPredicate;

    public DropTable(QualifiedName tableName, boolean existsPredicate)
    {
        this.tableName = tableName;
        this.existsPredicate = existsPredicate;
    }

    public QualifiedName getTableName()
    {
        return tableName;
    }

    public boolean isExistsPredicate()
    {
        return existsPredicate;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context)
    {
        return visitor.visitDropTable(this, context);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(tableName, existsPredicate);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        DropTable o = (DropTable) obj;
        return Objects.equals(tableName, o.tableName)
                && (existsPredicate == o.existsPredicate);
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("tableName", tableName)
                .add("existsPredicate", existsPredicate)
                .toString();
    }
}
