/*
 * Copyright 2019, The Android Open Source Project
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

package pl.pwr.andz1.i00000.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface BmiDatabaseDao {

    @Insert
    suspend fun insert(bmi_result: BmiResultObject)

    @Update
    suspend  fun update(bmi_result: BmiResultObject)

    @Query("SELECT * from bmi_result_table WHERE bmi_id = :key")
    suspend fun get(key: Long): BmiResultObject?

    @Query("DELETE FROM bmi_result_table")
    suspend fun clear()

    @Query("SELECT * FROM bmi_result_table ORDER BY bmi_id DESC LIMIT 10")
    suspend fun getAllResults(): List<BmiResultObject>


    @Query("SELECT * FROM bmi_result_table ORDER BY bmi_id DESC LIMIT 1")
    suspend fun getLastResult(): BmiResultObject?
}
