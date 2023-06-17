package com.booleanuk.api.models.dtos;

import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.User;
import lombok.Data;

@Data
public class CreateStats {
        private double weight;
        private double height;
        private String bodyFat;

        public Stats toStats(User user){
            return new Stats(user,weight,height,bodyFat);
        }

}
