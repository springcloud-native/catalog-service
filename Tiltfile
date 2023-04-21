# Build
custom_build(
    # Name of the container image
    ref = 'catalog-service',
    # Command to build the container image
    command = 'gradlew bootBuildImage --imageName ghcr.io/sudarshangrdy/catalog-service --publishImage -PregistryUrl=ghcr.io -PregistryUsername=sudarshangrdy -PregistryToken=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',
    # Files to watch that trigger a new build
    deps = ['build.gradle', 'src']
)
 
# Deploy
k8s_yaml(['k8s/deployment.yml', 'k8s/service.yml'])
 
# Manage
k8s_resource('catalog-service', port_forwards=['9001'])

allow_k8s_contexts('polar')