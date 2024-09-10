package com.example.flavors

import com.android.build.api.dsl.*
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.ProductFlavor

fun <BuildFeaturesT : BuildFeatures,
        BuildTypeT : BuildType,
        DefaultConfigT : DefaultConfig,
        ProductFlavorT : ProductFlavor,
        AndroidResourcesT : AndroidResources>

        CommonExtension<BuildFeaturesT, BuildTypeT, DefaultConfigT, ProductFlavorT, AndroidResourcesT>.versionsFlavor() {

    flavor("version", "free", "paid")

}

fun <BuildFeaturesT : BuildFeatures,
        BuildTypeT : BuildType,
        DefaultConfigT : DefaultConfig,
        ProductFlavorT : ProductFlavor,
        AndroidResourcesT : AndroidResources>

        CommonExtension<BuildFeaturesT, BuildTypeT, DefaultConfigT, ProductFlavorT, AndroidResourcesT>.clusterBrandFlavor() {

    flavorDimensions += listOf("cluster", "brand")
    productFlavors {
        create("daimler") {
            it.dimension = "cluster"
        }
        create("bmwGroup") {
            it.dimension = "cluster"
        }

        create("bmw") {
            it.dimension = "brand"
        }
        create("mercedes") {
            it.dimension = "brand"
        }
    }

}

private fun <BuildFeaturesT : BuildFeatures,
        BuildTypeT : BuildType,
        DefaultConfigT : DefaultConfig,
        ProductFlavorT : ProductFlavor,
        AndroidResourcesT : AndroidResources>

        CommonExtension<BuildFeaturesT, BuildTypeT, DefaultConfigT, ProductFlavorT, AndroidResourcesT>.flavor(dimension: String, vararg values: String) {

    flavorDimensions += dimension
    productFlavors {
        values.forEach { value ->
            create(value) {
                it.dimension = dimension
            }
        }
    }

}
