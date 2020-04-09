package com.epam.brest.courses.rest_app;

import com.epam.brest.courses.model.Transport;
import com.epam.brest.courses.service.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Transport Rest controller.
 */
@RestController
public class TransportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransportController.class);
    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    /**
     * Get all Transports.
     *
     * @return List<Transport> as Json.
     */
    @GetMapping(value = "/transports")
    public Collection<Transport> transports(){
        LOGGER.debug("transports()");
        return transportService.findAll();
    }

    /**
     * Add new Transport into DB.
     * @param transport Transport filled with data,
     * @return ResponseEntity<Integer> created transport id and http status 200.
     */
    @PostMapping(path = "/transports", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> createTransport(@RequestBody Transport transport) {
        LOGGER.debug("createTransport({})", transport);
        Integer id = transportService.create(transport);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
