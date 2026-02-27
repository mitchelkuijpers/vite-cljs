FROM aishell:base

RUN apt-get update  \
    && apt-get -y --no-install-recommends install  \
        # install any other dependencies you might need
        sudo curl git ca-certificates build-essential tmux \
    && rm -rf /var/lib/apt/lists/*

SHELL ["/bin/bash", "-o", "pipefail", "-c"]
ENV MISE_DATA_DIR="/mise"
ENV MISE_CONFIG_DIR="/mise"
ENV MISE_CACHE_DIR="/mise/cache"
ENV MISE_VERSION="v2026.2.22"

RUN export MISE_INSTALL_PATH="/usr/local/bin/mise" \
    && curl -fsSL https://mise.run | sh \
    && mkdir -p /mise/shims /mise/cache /mise/cache/lockfiles \
    && chown -R 501:1000 /mise \
    && ln -sf /usr/local/bin/mise /mise/shims/mise \
    && chmod +x /usr/local/bin/mise

ENV PATH="/mise/shims:$PATH"
