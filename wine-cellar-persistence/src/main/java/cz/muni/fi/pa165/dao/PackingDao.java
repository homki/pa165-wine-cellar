package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Packing;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Michaela Bamburová on 25.10.2016.
 */
public interface PackingDao {

    /**
     * Creates new packing in database.
     * @param packing
     */
    void createPacking(Packing packing);

    /**
     * Deletes given packing from database.
     * @param packing
     */
    void deletePacking(Packing packing);

    /**
     * Updates given packing in database.
     * @param packing
     */
    void updatePacking(Packing packing);

    /**
     * Finds packing by given id in database.
     * @param id id of packing
     * @return Packing with given id.
     */
    Packing findById(Long id);

    /**
     * Finds packings by given volume in database.
     * @param volume volume of packings
     * @return List of packing with given volume.
     */
    List<Packing> findPackingsByVolume(BigDecimal volume);

    /**
     * Finds all packings in database.
     * @return List of all packing.
     */
    List<Packing> findAll();
}
