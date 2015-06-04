/*!
 * PENTAHO CORPORATION PROPRIETARY AND CONFIDENTIAL
 *
 * Copyright 2002 - 2014 Pentaho Corporation (Pentaho). All rights reserved.
 *
 * NOTICE: All information including source code contained herein is, and
 * remains the sole property of Pentaho and its licensors. The intellectual
 * and technical concepts contained herein are proprietary and confidential
 * to, and are trade secrets of Pentaho and may be covered by U.S. and foreign
 * patents, or patents in process, and are protected by trade secret and
 * copyright laws. The receipt or possession of this source code and/or related
 * information does not convey or imply any rights to reproduce, disclose or
 * distribute its contents, or to manufacture, use, or sell anything that it
 * may describe, in whole or in part. Any reproduction, modification, distribution,
 * or public display of this information without the express written authorization
 * from Pentaho is strictly prohibited and in violation of applicable laws and
 * international treaties. Access to the source code contained herein is strictly
 * prohibited to anyone except those individuals and entities who have executed
 * confidentiality and non-disclosure agreements or other agreements with Pentaho,
 * explicitly covering such access.
 */

package org.pentaho.agilebi.modeler.models.annotations;

import org.apache.commons.lang.StringUtils;
import org.pentaho.agilebi.modeler.nodes.MeasureMetaData;
import org.pentaho.agilebi.modeler.nodes.MeasuresCollection;
import org.pentaho.metadata.model.olap.OlapDimensionUsage;
import org.pentaho.metadata.model.olap.OlapHierarchyLevel;
import org.pentaho.metadata.model.olap.OlapMeasure;

import java.util.List;

/**
 * @author Brandon Groves
 */
public final class AnnotationUtil {

  private AnnotationUtil() {
  }

  /**
   * Get {@link OlapHierarchyLevel} based on the name
   *
   * @param levelName Name of the dimension to find
   * @param hierarchyLevels list of dimensions
   * @return Found dimension otherwise null
   */
  public static OlapHierarchyLevel getOlapHierarchyLevel( final String levelName,
                                                          final List<OlapHierarchyLevel> hierarchyLevels ) {
    if ( StringUtils.isBlank( levelName ) || hierarchyLevels == null || hierarchyLevels.isEmpty() ) {
      return null;
    }

    OlapHierarchyLevel hierarchyLevel = null;

    for ( OlapHierarchyLevel level : hierarchyLevels ) {
      if ( levelName.equals( level.getName() ) ) {
        hierarchyLevel = level;
        break;
      }
    }

    return hierarchyLevel;
  }

  /**
   * Get {@link OlapDimensionUsage} based on the name
   *
   * @param dimensionName Name of the dimension to find
   * @param dimensionUsages list of dimensions
   * @return Found dimension otherwise null
   */
  public static OlapDimensionUsage getOlapDimensionUsage( final String dimensionName,
                                                          final List<OlapDimensionUsage> dimensionUsages ) {
    if ( StringUtils.isBlank( dimensionName ) || dimensionUsages == null || dimensionUsages.isEmpty() ) {
      return null;
    }

    OlapDimensionUsage foundDimensionUsage = null;

    for ( OlapDimensionUsage dimensionUsage : dimensionUsages ) {
      if ( dimensionName.equals( dimensionUsage.getName() ) ) {
        foundDimensionUsage = dimensionUsage;
        break;
      }
    }

    return foundDimensionUsage;
  }

  /**
   * Retrieves {@link OlapMeasure} based on the name
   *
   * @param measureName Name of the measure
   * @param olapMeasures list of measures
   * @return Found measure otherwise null
   */
  public static OlapMeasure getOlapMeasure( final String measureName, List<OlapMeasure> olapMeasures ) {
    if ( StringUtils.isBlank( measureName ) || olapMeasures == null || olapMeasures.isEmpty() ) {
      return null;
    }

    OlapMeasure olapMeasure = null;

    for ( OlapMeasure measure : olapMeasures ){
      if ( measureName.equals( measure.getName() ) ) {
        olapMeasure = measure;
      }
    }

    return olapMeasure;
  }

  /**
   * Retrieves {@link MeasureMetaData} based on the name.
   *
   * @param measureName Name of the measure
   * @param measures Collection of measures
   * @return FOund measure otherwise null
   */
  public static MeasureMetaData getMeasureMetaData( final String measureName,
                                                    MeasuresCollection measures ) {
    if ( StringUtils.isBlank( measureName ) || measures == null || measures.isEmpty() ) {
      return null;
    }

    MeasureMetaData measureMetaData = null;

    for ( MeasureMetaData measure : measures ){
      if ( measureName.equals( measure.getName() ) ) {
        measureMetaData = measure;
      }
    }

    return measureMetaData;
  }
}