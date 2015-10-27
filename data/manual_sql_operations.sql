-- INDICIES
CREATE INDEX weather_forecast_forecast_id_idx
  ON weather_forecast_day
  USING btree
  (weather_forecast_forecast_id);


CREATE INDEX day_hours_id_idx
  ON day_hourly
  USING btree
  (day_hours_id);