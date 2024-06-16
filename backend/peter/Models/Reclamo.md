```java
package uni.pe.DBD.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class reclamo {
    String id_reclamo;
    Timestamp fecha_reclamo;
    String descripcion_reclamo;
    String estado_reclamo;

}
