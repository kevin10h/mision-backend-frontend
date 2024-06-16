```java
package uni.pe.DBD.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class reclamo {
    String id_reclamo;
    String descripcion_reclamo;
    String estado_reclamo;

}
