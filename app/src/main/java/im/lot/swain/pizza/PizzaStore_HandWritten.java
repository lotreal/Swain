/*
 * Copyright (C) 2015 Hannes Dorfmann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.lot.swain.pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Hannes Dorfmann
 */
public class PizzaStore_HandWritten {

  public Meal order(String mealName) {

    if (mealName == null) {
      throw new IllegalArgumentException("Name of the meal is null!");
    }

    if ("Margherita".equals(mealName)) {
      return new MargheritaPizza();
    }

    if ("Calzone".equals(mealName)) {
      return new CalzonePizza();
    }

    if ("Tiramisu".equals(mealName)) {
      return new Tiramisu();
    }

    throw new IllegalArgumentException("Unknown meal '" + mealName + "'");
  }

  private static String readConsole() throws IOException {
    System.out.println("What do you like?");
    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
    String input = bufferRead.readLine();
    return input;
  }

  public static void main(String[] args) throws IOException {
    PizzaStore_HandWritten pizzaStore = new PizzaStore_HandWritten();
    Meal meal = pizzaStore.order(readConsole());
    System.out.println("Bill: $" + meal.getPrice());
  }
}
