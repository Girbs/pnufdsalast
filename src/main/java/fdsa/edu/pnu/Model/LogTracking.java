package fdsa.edu.pnu.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LogTracking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogTracking implements Serializable {


        @Column(name = "ID", nullable = false, length = 10)
        @Id
        @GeneratedValue(generator = "LOGID")
        @org.hibernate.annotations.GenericGenerator(name = "LOG ID", strategy = "native")
        private int id;

        public LogTracking(String methodName, String exception) {
                this.methodName = methodName;
                this.exception = exception;
        }

        private String methodName;

       // @Column(name = "exception", columnDefinition = "NVARCHAR(MAX)")
        private String exception;

}
