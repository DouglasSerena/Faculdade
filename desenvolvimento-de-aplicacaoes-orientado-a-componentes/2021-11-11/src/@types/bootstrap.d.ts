declare namespace bootstrap {
  class Modal {
    constructor(
      element: HTMLElement,
      options?: {
        keyboard?: boolean;
        backdrop?: "static" | boolean;
        focus?: boolean;
      }
    ): void;

    /** Manually toggles a modal. Returns to the caller before the modal has actually been shown or hidden (i.e. before the shown.bs.modal or hidden.bs.modal event occurs). */
    toggle(): void;

    /** @description Manually opens a modal. Returns to the caller before the modal has actually been shown (i.e. before the shown.bs.modal event occurs). */
    show(element: HTMLElement): void;
    show(): void;

    /** @description Manually hides a modal. Returns to the caller before the modal has actually been hidden (i.e. before the hidden.bs.modal event occurs). */
    hide(): void;

    /** @description Manually readjust the modal’s position if the height of a modal changes while it is open (i.e. in case a scrollbar appears). */
    handleUpdate(): void;

    /** @description Destroys an element’s modal. (Removes stored data on the DOM element) */
    dispose(): void;
  }
}
